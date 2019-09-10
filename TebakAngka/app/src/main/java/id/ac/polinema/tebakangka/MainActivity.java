package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int numInput, randomNumber;
	private Random random;
	private EditText numInputForm;
	private Button guessButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		numInputForm = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		random = new Random();
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		randomNumber = random.nextInt( 100) +1;

	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String numInputString = numInputForm.getText().toString();
		if (numInputString.equalsIgnoreCase("")){
			Toast.makeText( this, "Input Harus Angka", Toast.LENGTH_SHORT).show();
		}else {
			numInput = Integer.parseInt(numInputString);
			if (numInput > randomNumber) {
				Toast.makeText( this, "Tebakan Anda Terlalu Besar", Toast.LENGTH_SHORT).show();
			}else if (numInput < randomNumber){
				Toast.makeText( this, "Tebakan Anda Terlalu Kecil", Toast.LENGTH_SHORT).show();
			} else if (numInput == randomNumber) {
				Toast.makeText(this, "Tebakan Anda Benar", Toast.LENGTH_SHORT).show();
				guessButton.setEnabled(false);
			}
		}

	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numInputForm.setText("");
		initRandomNumber();
		guessButton.setEnabled(true);
	}
}
