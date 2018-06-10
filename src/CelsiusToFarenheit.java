import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CelsiusToFarenheit extends JFrame implements ActionListener
{

	private static final long serialVersionUID = -8476876886259664341L;
	
	private JLabel lCelsius, lFarenheit;
	private JTextField tCelsius, tFarenheit;
	private JButton bKonweruj;
	private ButtonGroup bgRozmiar;
	private JRadioButton rbMa�y, rb�redni, rbDu�y;
	private JCheckBox chWielkie;
	private double tempCelsius, tempFahrenheit;
	
	public CelsiusToFarenheit()
	{
		setSize(380,220);
		setTitle("Celsius To Fahrenheit konwerter");
		setLayout(null);
		
		lCelsius = new JLabel("Stopnie Celsiusza:");
		lCelsius.setBounds(20, 20, 150, 20);
		add(lCelsius);
		
		tCelsius = new JTextField("");
		tCelsius.setBounds(170, 20, 150, 20);
		tCelsius.setText("0");
		add(tCelsius);
		tCelsius.setToolTipText("Podaj temperatur� w stopniach Celsiusza");
		tCelsius.addActionListener(this);
		
		lFarenheit = new JLabel("Stopnie Fahrenheita:");
		lFarenheit.setBounds(20, 70, 150, 20);
		add(lFarenheit);
		
		tFarenheit = new JTextField("");
		tFarenheit.setBounds(170, 70, 150, 20);
		add(tFarenheit);
		tFarenheit.setToolTipText("Wynik przeliczenia temperatury");
		
		bKonweruj = new JButton("Konwertuj");
		bKonweruj.setBounds(100, 120, 150, 20);
		add(bKonweruj);
		bKonweruj.setToolTipText("Inicjuje przeliczenie temperatury");
		bKonweruj.addActionListener(this);
		
//		Start konfigurowania RadioButon�w
		bgRozmiar = new ButtonGroup();
		
		rbMa�y = new JRadioButton("Ma�y", true);
		rbMa�y.setBounds(50, 150, 100, 20);
		bgRozmiar.add(rbMa�y);
		add(rbMa�y);
		rbMa�y.setToolTipText("Ma�y rozmiar czcionki pola z Wynikiem");
		rbMa�y.addActionListener(this);
		
		rb�redni = new JRadioButton("�redni", false);
		rb�redni.setBounds(150, 150, 100, 20);
		bgRozmiar.add(rb�redni);
		add(rb�redni);
		rb�redni.setToolTipText("�redni rozmiar czcionki pola z Wynikiem");
		rb�redni.addActionListener(this);
		
		rbDu�y = new JRadioButton("Du�y", false);
		rbDu�y.setBounds(250, 150, 100, 20);
		bgRozmiar.add(rbDu�y);
		add(rbDu�y);
		rbDu�y.setToolTipText("Du�y rozmiar czcionki pola z Wynikiem");
		rbDu�y.addActionListener(this);
		
		chWielkie = new JCheckBox("Pogrubienie");
		chWielkie.setBounds(250, 120, 150, 20);
		add(chWielkie);
		chWielkie.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		CelsiusToFarenheit aplikacja = new CelsiusToFarenheit();
		aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aplikacja.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object �r�d�o = e.getSource();
		if ((�r�d�o==bKonweruj) || (�r�d�o==tCelsius))
		{
			tempCelsius = Double.parseDouble(tCelsius.getText());
			tempFahrenheit = 32.0 + (9.0/5.0) * tempCelsius;
			tFarenheit.setText(String.valueOf(tempFahrenheit));
		}
		else if ((�r�d�o==bgRozmiar) || (rbMa�y.isSelected()))
		{
			if (chWielkie.isSelected())
			{
				tFarenheit.setFont(new Font("SansSerif" , Font.BOLD , 12));
			}
			else
			{
				tFarenheit.setFont(new Font("SansSerif" , Font.PLAIN , 12));	
			}
		}
		else if ((�r�d�o==bgRozmiar) || (rb�redni.isSelected()))
		{
			if (chWielkie.isSelected())
			{
				tFarenheit.setFont(new Font("SansSerif" , Font.BOLD , 14));
			}
			else
			{
				tFarenheit.setFont(new Font("SansSerif" , Font.PLAIN , 14));	
			}
		}
		else if ((�r�d�o==bgRozmiar) || (rbDu�y.isSelected()))
		{
			if (chWielkie.isSelected())
			{
				tFarenheit.setFont(new Font("SansSerif" , Font.BOLD , 18));
			}
			else
			{
				tFarenheit.setFont(new Font("SansSerif" , Font.PLAIN , 18));	
			}
		}
	}
	
	
}