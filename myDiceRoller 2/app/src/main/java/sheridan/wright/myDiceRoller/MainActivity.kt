package sheridan.wright.myDiceRoller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import sheridan.wright.myDiceRoller.model.Die
import sheridan.wright.myDiceRoller.model.Total


class MainActivity : AppCompatActivity() {

    companion object{
        const val CURRENT_DIE_VALUE = "current_die_value"
        const val CURRENT_TOTAL = "current_total"
    }

    //total and die values
    private val die = Die()
    private val total = Total()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add click listener on roll button
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice() }

        //Add click listener in die image
        val imageViewDice: ImageView = findViewById(R.id.image_view_dice)
        imageViewDice.setOnClickListener{ rollDice() }

        //Add click listener of reset button
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener{ reset() }

        if(savedInstanceState is Bundle){ //savedInstanceState != null
            die.value = savedInstanceState.getInt(CURRENT_DIE_VALUE)
            total.total = savedInstanceState.getInt(CURRENT_TOTAL)
        }

        //display the die and total values on startup
        displayDice()
        displayTotal()
    }

    //Save total and die values on rotation
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_DIE_VALUE, die.value)
        outState.putInt(CURRENT_TOTAL, total.total)
    }

    //roll the dice and update display
    private fun rollDice(){
        Toast.makeText(this, "dice rolled", Toast.LENGTH_SHORT).show()
        die.roll()
        displayDice()
        updateTotal()
    }

    //Update die display
    private fun displayDice() {
        val resultText: TextView = findViewById(R.id.die_value)
        when (die.value){
            0 -> image_view_dice.setImageResource(R.drawable.dice1)
            1 -> image_view_dice.setImageResource(R.drawable.dice1)
            2 -> image_view_dice.setImageResource(R.drawable.dice2)
            3 -> image_view_dice.setImageResource(R.drawable.dice3)
            4 -> image_view_dice.setImageResource(R.drawable.dice4)
            5 -> image_view_dice.setImageResource(R.drawable.dice5)
            6 -> image_view_dice.setImageResource(R.drawable.dice6)
        }
        resultText.text =
            if (die.value > 0)
                die.value.toString()
            else "Roll the die!"
    }

    //display new total
    private fun displayTotal(){
        val totalText: TextView = findViewById(R.id.roll_total)
        totalText.text = total.total.toString()
    }

    //calculate new total
    private fun updateTotal(){
        total.total += die.value
        displayTotal()
    }

    //reset values to start positions
    private fun reset(){
        Toast.makeText(this, "total reset", Toast.LENGTH_SHORT).show()
        total.total = 0
        die.value = 0
        displayDice()
        displayTotal()
    }
}