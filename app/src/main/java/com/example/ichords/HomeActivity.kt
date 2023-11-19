import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ichords.SplashActivity

class HomeActivity : AppCompatActivity() {
    // ... outras partes da sua atividade ...

    // Método chamado quando a ImageView é clicada
    fun onImageViewClick(view: View) {
        // Iniciar a SplashActivity ao clicar na ImageView
        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
    }
}
