'use client';
import { useEffect, useState } from "react";
import { Ticket } from "./entities/ticket";
import { listarTickets, crearTicket, actualizarTicket, borrarTicket } from "./funciones";

export default function Home() {
    const [tickets, setTickets] = useState<Ticket[]>([]);
    const [ticketSeleccionado, setTicketSeleccionado] = useState<number | undefined>(0);

    async function cargarTickets() {
        try{
            const lista = await listarTickets();
            setTickets(lista);
        } catch (error) {
        }
    }

    async function agregarTicket(formData: FormData){
        await crearTicket(formData);
        cargarTickets();
    }

    async function actualizarEstado(codigo?: number, estado?: string){
        await actualizarTicket(codigo, estado);
        cargarTickets()
    }

    async function eliminar(codigo?: number) {
        await borrarTicket(codigo);
        setTicketSeleccionado(0);
        cargarTickets();
    }

    useEffect(() => {
        cargarTickets();
    }, []);

return (
        <div className="container">
            <h1>Gestión de Tickets</h1>
            <form action={agregarTicket}>
                <input type="text" name="usuario" placeholder="Usuario" required />
                <input type="text" name="descripcion" placeholder="Descripción" required />
                <input type="text" name="estado" placeholder="Estado" required />
                <button type="submit">Crear Ticket</button>
            </form>

            <h2>Lista de Tickets</h2>
            <ul>
                {tickets.map((ticket) => (
                    <li
                        key={ticket.codigo}
                        onClick={() => setTicketSeleccionado(ticket.codigo)}
                        className={ticketSeleccionado === ticket.codigo ? "selected" : ""}
                    >
                        <p><strong>Usuario:</strong> {ticket.usuario}</p>
                        <p><strong>Descripción:</strong> {ticket.descripcion}</p>
                        <p><strong>Estado:</strong> {ticket.estado}</p>

                        {ticketSeleccionado === ticket.codigo && (
                            <div className="ticket-actions">
                                <select
                                    onChange={(e) => actualizarEstado(ticket.codigo, e.target.value)}
                                    defaultValue={ticket.estado}
                                >
                                    <option value="pendiente">Pendiente</option>
                                    <option value="en proceso">En Proceso</option>
                                    <option value="resuelto">Resuelto</option>
                                </select>
                                <button className="delete-btn" onClick={() => eliminar(ticket.codigo)}>
                                    Eliminar
                                </button>
                            </div>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );}
