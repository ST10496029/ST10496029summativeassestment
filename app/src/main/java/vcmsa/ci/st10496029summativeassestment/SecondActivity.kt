package vcmsa.ci.st10496029summativeassestment

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)



        //getting the input data from the mainActivity that was sent with the intent using getstringarrayextra
        val recipes = intent.getStringArrayExtra("RECIPETITLES")?: arrayOf()
        val categorys = intent.getStringArrayExtra("CATEGORYSNAMES")?: arrayOf()
        val ratings = intent.getStringArrayExtra("RATINGSNAMES")?: arrayOf()
        val ingredients = intent.getStringArrayExtra("INGREDIENTNAMES")?: arrayOf()



        val recipeDisplayTextView = findViewById<TextView>(R.id.recipeDisplayTextView)
        val printRecipeButton = findViewById<Button>(R.id.printRecipeButton)
        val backButton = findViewById<Button>(R.id.backButton)

        printRecipeButton.setOnClickListener {
            for (i in recipes.indices){
                println("$recipes[i], $categorys[i], $ratings[i], $ingredients[i]")
            }
        }

// button that will take user bac to the main screen
        backButton.setOnClickListener {
            finish()
        }


    }

    }
