'use server';
import { stringify } from "querystring";
import { Ticket } from "./entities/ticket";

export async function crearTicket(formData: FormData) {
    let ticket = new Ticket();
    ticket.usuario = String(formData.get('usuario'));
    ticket.descripcion = String(formData.get('descripcion'));
    ticket.estado = String(formData.get('estado'));

    const request = JSON.stringify(ticket);
    console.log('Request: ', request);

    const data = await fetch('http://localhost:8080/tickets/agregar', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: request,
    });
    const res = await data.json();
    console.log('Response: ', res);
    return res;
}

export async function listarTickets() {
    const data = await fetch('http://localhost:8080/tickets/listar');
    const lista = await data.json();
    console.log('Lista: ',lista);
    return lista;
}

export async function borrarTicket(codigo?: number) {
    const data = await fetch(`http://localhost:8080/tickets/borrar?codigo=${codigo}`, {
        method: "DELETE",
    });
    const res = await data.json();
    console.log('Response: ', res);
    return res;
}

export async function actualizarTicket(codigo?: number, estado?: string) {
    const data = await fetch(`http://localhost:8080/tickets/actualizar?codigo=${codigo}&estado=${estado}`, {
        method: "PUT",
    });
    const res = await data.json();
    console.log('Response: ', res);
    return res;
}
