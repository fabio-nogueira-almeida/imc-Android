package fabio.nogueira;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ImcActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       
        Button btnSomar = (Button) findViewById(R.id.btnSomar);
        final EditText txtAltura = (EditText) findViewById(R.id.txtAltura);
        final EditText txtPeso = (EditText) findViewById(R.id.txtPeso);
        final EditText txtResultado = (EditText) findViewById(R.id.txtResultado);
        final EditText txtClassificacao = (EditText) findViewById(R.id.txtClassificacao);
        
       



        btnSomar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
		         float altura = Float.valueOf(txtAltura.getText().toString());
		         float peso = Float.valueOf(txtPeso.getText().toString());
				
				float valor = calcular(altura,peso);
				String valClassificacao = classificacao(valor);
				
				txtResultado.setText(String.valueOf(valor));
		    	txtClassificacao.setText(String.valueOf(valClassificacao));
		    	
		    	
			};
		});
        
    }
    
    public float calcular(float altura, float peso){
    	
    	float imc = (altura*altura);
    	imc = peso / imc;
    	return imc;
		}
    
    private String classificacao(float valor){
		//valores tirado do wikipedia
    	
    //	DecimalFormat df = new DecimalFormat();
    //	df.applyPattern("00.0");
    //	string imcValor = df.format(valor);
    	
    	if (valor <= 18.5f){
    		return "Abaixo do peso";
    	} else if (valor >= 18.6f && valor <= 24.9f){
    		return "Saud‡vel";
    	} else if (valor >= 25f && valor <= 29.9f){
    		return "Peso em excesso";
    	} else if (valor >= 30f && valor <= 34.9f){
    		return "Obesidade Grau I";
    	} else if (valor >= 35f && valor <= 39.9f){
    		return "Obesidade Grau II (severa)";
    	} else {
    		return "Obesidade Grau III (m—rbida) ";
    	}
    }
   
    
}

        
        
        
        
        
     

        


        
    	
    	

       
    