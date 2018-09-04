package ktmfirevaseapp.com.autenticacao;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //CADASTRO
        /*Método para realizar autenticcação verificar se esta logado login e logout
        firebaseAuth = FirebaseAuth.getInstance();

        //@param1 email @param2 senha autenticação cm email    usar caixas de entrada
        firebaseAuth.createUserWithEmailAndPassword("kausarcastico@gmail.com","kausarcastico")
                .addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>(){
                    @Override                //@para1 context @param2 instancia um classe anonima
                    public void onComplete(@NonNull Task<AuthResult>task){
                        if(task.isSuccessful()){//cadastro bem sucedido
                            Log.i("auth","cadastrado com sucesso");
                        }else Log.i("auth","cadastro falhou");
                    }
                });<<- adiciona um trecho de cógido desejado quando o usuario for cadastrado/finalizado */

        //LOGAR
        firebaseAuth = FirebaseAuth.getInstance();

        //@param1 email @param2 senha
        firebaseAuth.signInWithEmailAndPassword("kausarcastico@gmail.com","kausarcastico")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.v("login","Logou com sucesso");
                        }else Log.v("login","não foi possivel logar");
                    }
        });

        //DESLOGAR USUARIO
        //desloga usuario que está logado
        firebaseAuth.signOut();


        //VERIFICA SE O USUÁRIO ESTÁ LOGADO
        //recupera o usuario atual com metodo getCurrenteUser ou null
        if (firebaseAuth.getCurrentUser() != null) {
            Log.v("logado","usuario logado");
        }else Log.v("logado","usuario não está logado");
    }
}
