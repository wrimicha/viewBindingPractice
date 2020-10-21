package sheridan.wright.myDiceRoller.model

import android.util.Log
import java.lang.IllegalArgumentException

class Die() {

    //default value, and setter
    var value: Int = 0
        set(n) {
            if (n in 0..6) {
                field = n
            } else {
                Log.e("Die", "Illegal die value $n")
                throw IllegalArgumentException("Illegal die value $n")
            }
        }

    constructor(n: Int) : this() {
        value = n
    }

    fun roll() {
        value = (1..6).random()
    }
}