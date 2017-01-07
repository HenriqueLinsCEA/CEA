package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.JLabel;

// colocar esses metodos para gerar relogio em tempo real

class Relogio extends TimerTask {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	private JLabel lblHoraAtual;

	public Relogio(JLabel lblHoraAtual) {
		this.lblHoraAtual = lblHoraAtual;
	}

	public void run() {
		lblHoraAtual.setText(sdf.format(new Date()));
	}

	/*
	 * Timer t = new Timer(); t.scheduleAtFixedRate(new Relogio(lblHoraAtual),
	 * 0, 1000);
	 */

}
