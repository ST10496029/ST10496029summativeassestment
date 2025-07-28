
    //KIJU NATANA ST10496029

    // four parllel arrays declared
    val recipe = arrayOf<String>("","","","")
    val category = arrayOf<String>("","","","")
    val rating = arrayOf<String>("","","","")
    val ingredients = arrayOf<String>("","","","")

    //creating a mutable variable counter for the arrays that is initialised to zero
    var arrayCounter = 0

    //a function created to add user input later to array
    fun addToArray(recipes:String, categorys:String, ratings:String, ingredient:String){
        recipe[arrayCounter] = recipes

        category[arrayCounter] = categorys

        rating[arrayCounter] = ratings

        ingredients[arrayCounter] = ingredient
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)




        // textview is called unto using find by view id method
        val recipeTextView = findViewById<TextView>(R.id.recipeTextView)
        val categoryTextView = findViewById<TextView>(R.id.categoryTextView)
        val ratingTextView = findViewById<TextView>(R.id.ratingTextView)
        val ingredientTextView = findViewById<TextView>(R.id.ingredientTextView)

        // button to add to arrays
        val addButton = findViewById<Button>(R.id.addButton)


        // adding on click listener to give the button ann action when clicked
        addButton.setOnClickListener {


            //using tostring()/ .text to convert the user input data into strings
            val recipes = recipeTextView.text.toString()

            val categorys = categoryTextView.text.toString()

            val ratings = ratingTextView.text.toString()

            val ingredients = ingredientTextView.text.toString()

            // if statement that will be executed incase of an error in input
            if(recipes.isNotBlank() && categorys.isNotBlank() && ratings.isNotBlank() && ingredients.isNotBlank()){


                // funtion i created before that is  called to add input data to the arrays
                addToArray(recipes, categorys, ratings, ingredients)

                //toast that will appear letting the user know there recipe was added
                Toast.makeText(this, "$recipes Added to Recipes", Toast.LENGTH_SHORT).show()
            } else{

                ////toast that will appear incase of an input error
                Toast.makeText(this, "Please fill In All Fields", Toast.LENGTH_SHORT).show()
            }
        }

        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener{

            // creating an intent that will take user to the next activity
            intent = Intent(this,   SecondActivity::class.java)

            //using .putextra to add to the intent the arrays data that will be sent to the next activity
            intent.putExtra("RECIPETITLES", recipe)

            intent.putExtra("CATEGORYNAMES", category)

            intent.putExtra("RATINGNAMES", category)

            intent.putExtra("INGREDIENTNAMES", ingredients)

            startActivity(intent)
        }



    }




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

                //recipeDisplayTextView.text =
            }
        }

// button that will take user bac to the main screen
        backButton.setOnClickListener {
            finish()
        }


    }

    }
