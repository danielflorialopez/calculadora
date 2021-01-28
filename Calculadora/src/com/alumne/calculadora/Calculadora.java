package com.alumne.calculadora;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
//prova 
//Després de modificar la ruta als JAR i al JRE (default) feu un commit sense pujar el fitxer .classpath
//Aneu amb compte amb la codificació de caracters perquè produeix errors de compilació difícils de detectar, potser falla un import per un caracter invisible

public class Calculadora {

	// Constants
	final int MAX_DIGITS = 5;
	final int MODE_ENTRADA = 0;
	final int MODE_RESULTAT = 1;

	// Variables
	int mode;
	int valor1;
	int valor2;
	String operacio;
	boolean inicialitza_resultat;

	// private static String text_resultat;

	protected Shell shell;
	private static Text text_resultat;

	/**
	 * Constructor de la classe calculadora amb paràmetre
	 * 
	 * @param gui indica si s'ha de pintar la interfície o funciona en mode comandes
	 */

	public Calculadora(boolean gui) {

		// Inicialització de les variables.
		inicialitza();

		if (gui == true)
			dibuixaCalculadora();

	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Normalment executarem la calculadora en mode grafic (true) pero per a
			// depuracio la usarem en mode terminal (false)
			Calculadora window = new Calculadora(true);
			// El codi generat automaticament usa el metode window.open() en comptes de
			// dibuixaCalculadora
			// window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	// El codi generat automaticament usa el metode window.open() en comptes de
	// dibuixaCalculadora
	// public void open() {
	private void dibuixaCalculadora() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		// shell.setSize(450, 300);
		shell.setSize(259, 250);
		shell.setText("Calculadora");

		// -------------------------------------------------
		// Números
		// -------------------------------------------------

		Button button_0 = new Button(shell, SWT.NONE);
		button_0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(0);
			}
		});
		button_0.setBounds(23, 163, 40, 33);
		button_0.setText("0");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(1);
			}
		});
		button_1.setBounds(23, 124, 40, 33);
		button_1.setText("1");

		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(2);
			}

		});
		button_2.setText("2");
		button_2.setBounds(69, 124, 40, 33);

		// butò amb el número 3
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(3);
			}
		});
		button_3.setText("3");
		button_3.setBounds(115, 124, 40, 33);

		// butò amb el número 4
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(4);
			}
		});
		button_4.setText("4");
		button_4.setBounds(23, 85, 40, 33);

		// butò amb el número 5
		Button button_5 = new Button(shell, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(5);
			}
		});
		button_5.setText("5");
		button_5.setBounds(69, 85, 40, 33);

		// butò amb el número 6
		Button button_6 = new Button(shell, SWT.NONE);
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(6);
			}
		});
		button_6.setText("6");
		button_6.setBounds(115, 85, 40, 33);

		// butò amb el número 7
		Button button_7 = new Button(shell, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(7);
			}
		});
		button_7.setText("7");
		button_7.setBounds(23, 46, 40, 33);

		// butò amb el número 8
		Button button_8 = new Button(shell, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(8);
			}
		});
		button_8.setBounds(69, 46, 40, 33);
		button_8.setText("8");

		// butò amb el número 9
		Button button_9 = new Button(shell, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				afegeixNouDigit(9);
			}
		});
		button_9.setText("9");
		button_9.setBounds(115, 46, 40, 33);

		// -------------------------------------------------
		// Operacions
		// -------------------------------------------------

		// butò amb l'operació de divisió
		Button button_12 = new Button(shell, SWT.NONE);
		button_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executarOperador("/");
			}
		});
		button_12.setText("/");
		button_12.setBounds(178, 46, 40, 33);

		// butò amb l'operació de multiplicació
		Button button_13 = new Button(shell, SWT.NONE);
		button_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executarOperador("*");
			}
		});
		button_13.setText("*");
		button_13.setBounds(178, 85, 40, 33);

		// butò amb l'operació de suma
		Button button_14 = new Button(shell, SWT.NONE);
		button_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executarOperador("+");
			}
		});
		button_14.setText("+");
		button_14.setBounds(178, 124, 40, 33);

		// butò amb l'operació de resta
		Button button_15 = new Button(shell, SWT.NONE);
		button_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executarOperador("-");
			}
		});
		button_15.setText("-");
		button_15.setBounds(178, 163, 40, 33);

		// butò amb l'operació de igual
		Button button_11 = new Button(shell, SWT.NONE);
		button_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				executarIgual();
			}
		});
		button_11.setText("=");
		button_11.setBounds(69, 163, 86, 33);

		// Text on es visualitza el resultat
		text_resultat = new Text(shell, SWT.BORDER);
		text_resultat.setText("0");
		text_resultat.setBounds(22, 19, 196, 21);

	}

	// serveix per a definir les variables, inicialitzar-les
	public void inicialitza() {
		operacio = "null";
		valor1 = 0;
		valor2 = 0;
		mode = MODE_ENTRADA;
		inicialitza_resultat = true;
	}

	// retorna el text de text_resultat
	public String getResultatString() {
		return text_resultat.getText();
	}

	// seteja el text de text_resultat amb el valor de s
	public void setResultatString(String s) {
		text_resultat.setText(s);
	}

	// retorna el text de text_resultat en forma d'int
	public int getResultatInt() {
		String resultat = text_resultat.getText();
		return Integer.parseInt(resultat);
	}

	// llegim el text que hi ha a setresultats i concatenem els diferents numeros

	public void afegeixNouDigit(int digit) {
		if (inicialitza_resultat)
			setResultatString("");

		String inputString = getResultatString();

		// Elimina repeticio de zeros inicial
		if (inputString.indexOf("0") == 0) {
			inputString = inputString.substring(1);
		}

		// Concatena el nou digit amb el que teniem
		if ((!inputString.equals("0") || digit > 0) && inputString.length() < MAX_DIGITS) {
			setResultatString(inputString + digit);
		}

		mode = MODE_ENTRADA;
		inicialitza_resultat = false;
	}

	// aquí s'acaben els meus comentaris
	public void executarOperador(String new_operacio) {

		int resultat;
		inicialitza_resultat = true;
		operacio = new_operacio;
		// si la operacio es null, guardem en int el resultat, i el primer valor al resultat
		if (operacio.equals("null")) {
			resultat = getResultatInt();
			valor1 = resultat;
		//si no es null guardem el segon valor en int, executa la operacio i mostra el resultat 
		} else {
			valor2 = getResultatInt();
			resultat = executarOperacio();
			mostraResultat(resultat);
			valor1 = resultat;
		}

	}

	// torna la operacio a null
	public void executarIgual() {
		int resultat = 0;
		//guarda el resultat en int al valor 2. guardem el resultat de la operacio al resultat i el mostrem.
		valor2 = getResultatInt();
		resultat = executarOperacio();
		mostraResultat(resultat);

		operacio = "null";
	}

	// Fa la operacio
	public int executarOperacio() {
		int resultat = 0;

		//aquest es l'if de la divisio
		if (operacio.equals("/")) {

			// si el valor dos es igual a 0 ens diu l'error "No es pot dividir per cero" si no es igual a 0 fa la operacio
			if (valor2 == 0) {
				JOptionPane.showMessageDialog(null, "No es pot dividir per cero", "Error", JOptionPane.ERROR_MESSAGE);
				operacio = "null";
				valor1 = 0;
				mode = MODE_ENTRADA;
				inicialitza_resultat = true;
			} else {
				resultat = valor1 / valor2;
			}

			// ... i descomentar aquesta part per a produir l'excepció
			// resultat = valor1 / valor2;
		}
		//segons el simbol far� les operacions sumar, restar o multiplicar
		if (operacio.equals("*"))
			resultat = valor1 * valor2;

		if (operacio.equals("-"))
			resultat = valor1 - valor2;

		if (operacio.equals("+"))
			resultat = valor1 + valor2;

		return resultat;
	}

	// 	Mostra el resultat de les operacions
	public void mostraResultat(int resultat) {
		setResultatString(Integer.toString(resultat));
		valor1 = resultat;
		mode = MODE_RESULTAT;
		inicialitza_resultat = true;
	}

}