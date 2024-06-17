package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Informe o numero do quarto");
			int numQuarto = sc.nextInt();
			System.out.println("Data de Check-In (dd/MM/yyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-Out : (dd/MM/yyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
			System.out.println(reserva.toString());
	
			System.out.println();
			System.out.println("entre com a data para atualizar: ");
			System.out.println("Data de Check-In (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-Out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			reserva.updateDates(checkIn, checkOut);
			System.out.println(reserva.toString());
		}
		catch(ParseException e) {
			System.out.println("Digitou uma data invalida. ");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		sc.close();
	}
}