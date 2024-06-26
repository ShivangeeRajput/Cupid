import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cupid.R
import com.example.cupid.ui.activity.Onboarding.AddEmail
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignUp : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var secondNameEditText: EditText
    private lateinit var nextButton: Button

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        firstNameEditText = findViewById(R.id.firstName)
        secondNameEditText = findViewById(R.id.secondName)
        nextButton = findViewById(R.id.next)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        nextButton.setOnClickListener {
            saveUserDataToFirestore()
        }
    }

    private fun saveUserDataToFirestore() {
        val firstName = firstNameEditText.text.toString().trim()
        val lastName = secondNameEditText.text.toString().trim()

        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName)) {
            Toast.makeText(this, "Please enter your first name and last name", Toast.LENGTH_SHORT).show()
            return
        }

        val userId = mAuth.currentUser?.uid
        if (userId != null) {
            val user = hashMapOf(
                "firstName" to firstName,
                "lastName" to lastName
            )

            db.collection("users").document(userId)
                .set(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Name saved successfully!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, AddEmail::class.java))
                    finish() // Finish current activity to prevent going back
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error saving name: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show()
        }
    }
}
