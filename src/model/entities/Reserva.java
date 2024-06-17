package model.entities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numQuarto;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer numQuarto, Date checkin, Date checkout) throws DomainException {
		if(!checkout.after(checkin)) {
			throw new DomainException("Check-out tem que ser posterior ao check-in");
		}
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		// Pega a diferenca entre as datas em milisegundos
		long diff = checkout.getTime() - checkin.getTime();

		// classe do java responsavel por converter a variavel diff de milisegundos para
		// dias;

		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {

		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("A data da reserva precisa ser feita para uma data futura");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Data de check-out tem que ser posterior a do check-in");
		}
		this.checkin = checkIn;
		this.checkout = checkOut;

	}

	@Override
	public String toString() {
		return "Quarto: " + numQuarto + ", check - in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout)
				+ ", " + duration() + " noites.";
	}
}
