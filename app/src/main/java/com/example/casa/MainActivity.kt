package com.example.casa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        abstract class Dwelling(var residents: Int) {

            abstract val buildingMaterial: String
            abstract val capacity: Int

            fun hasRoom(): Boolean {
                return residents < capacity
            }
        }



        fun main() {


            with("squareCabin") {
                println("\nSquare Cabin\n============")
                println("Capacity: ${capacity}")
                println("Material: ${buildingMaterial}")
                println("Has room? ${hasRoom()}")
            }
        }

        open class RoundHut(residents: Int) : Dwelling(residents) {
            override val buildingMaterial = "Straw"
            override val capacity = 4
        }
        val roundHut = RoundHut(3)
        with(roundHut) {
            println("\nRound Hut\n=========")
            println("Material: ${buildingMaterial}")
            println("Capacity: ${capacity}")
            println("Has room? ${hasRoom()}")
        }

        class RoundTower(residents: Int, val floors: Int = 2) : RoundHut(residents) {
            override val buildingMaterial = "Stone"
            override val capacity = 4 * floors
        }

        val roundTower = RoundTower(4)
        with(roundTower) {
            println("\nRound Tower\n==========")
            println("Material: ${buildingMaterial}")
            println("Capacity: ${capacity}")
            println("Has room? ${hasRoom()}")
        }


    }
}