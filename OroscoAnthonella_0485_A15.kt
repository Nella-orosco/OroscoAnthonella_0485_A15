import java.util.Scanner
import kotlin.random.Random

fun main() {
    val sc = Scanner(System.`in`)
    var salir = false

    println(""" 
        ╔═════════════════════════════════════════════╗
        ║                                             ║
        ║  Bienvenido al juego, gracias por ingresar  ║
        ║                                             ║
        ╚═════════════════════════════════════════════╝

    """.trimIndent())
    while (!salir) {
        println("""--- MENÚ PRINCIPAL ---
            |1. Opciones de juego.
            |2. Instrucciones.
            |3. Salir.
            |Elige una opción:
        """.trimMargin())
        val opcion = sc.nextInt()

        when(opcion) {
            1 -> { // Submenú de juegos
                var volver = false
                while (!volver) {
                    println("\n--- OPCIONES DE JUEGO ---")
                    println("1. Juego normal (Pedra-Paper-Tisora)")
                    println("2. Sheldon Cooper (Pedra-Paper-Tisora-Llangardaix-Spock)")
                    println("3. Volver al menú principal")
                    print("Elige una opción: ")
                    val juego = sc.nextInt()
                    when(juego) {
                        1 -> juegoNormal(sc)
                        2 -> juegoSheldon(sc)
                        3 -> volver = true
                        else -> println("Opción inválida, intenta de nuevo.")
                    }
                }
            }
            2 -> { // Instrucciones
                println("\n--- INSTRUCCIONES ---")
                println("""Juego normal: Elige Pedra (1), Paper (2) o Tisora (3). 
                    Reglas:
                      - Pedra a Tisora.
                      - Tisora a Paper.
                      - Paper a Pedra.""".trimMargin())
                println("""Juego Sheldon: Elige Pedra (1), Paper (2), Tisora (3), Llangardaix (4) o Spock (5).
                     Reglas:
                      - Tijera corta Papel y decapita Lagarto.
                      - Papel envuelve Piedra y desautoriza Spock.
                      - Piedra aplasta Lagarto y aplasta Tijera.
                      - Lagarto envenena Spock y devora Papel.
                      - Spock vaporiza Piedra y deshace Tijera.""")
            }
            3 -> {
                println("¡Gracias por jugar! :)")
                salir = true
            }
            else -> println("Opción inválida, intenta de nuevo.")
        }
    }
}

// Juego normal: Pedra-Paper-Tisora
fun juegoNormal(sc: Scanner) {
    var partidas = 0
    var jugadorGana = 0
    var maquinaGana = 0
    var empates = 0
    var jugar = true

    while (jugar) {
        var jugadaUsuario = 0
        while (jugadaUsuario !in 1..3) {
            print("Elige tu jugada (1=Pedra, 2=Paper, 3=Tisora): ")
            jugadaUsuario = sc.nextInt()
            if (jugadaUsuario !in 1..3) println("Jugada inválida, intenta de nuevo.")
        }

        val jugadaMaquina = Random.nextInt(1, 4)
        val nombre = arrayOf("", "Pedra", "Paper", "Tisora")
        println("Jugador: ${nombre[jugadaUsuario]} vs Máquina: ${nombre[jugadaMaquina]}")

        if (jugadaUsuario == jugadaMaquina) empates++
        else if ((jugadaUsuario == 1 && jugadaMaquina == 3) ||
            (jugadaUsuario == 2 && jugadaMaquina == 1) ||
            (jugadaUsuario == 3 && jugadaMaquina == 2)) jugadorGana++
        else maquinaGana++

        partidas++
        print("¿Quieres jugar otra vez? (s/n): ")
        val respuesta = sc.next()
        jugar = respuesta.lowercase() == "s"
    }

    println("\nEstadísticas finales:")
    println("Partidas jugadas: $partidas")
    println("Jugador ganó: ${jugadorGana * 100.0 / partidas}%")
    println("Máquina ganó: ${maquinaGana * 100.0 / partidas}%")
    println("Empates: ${empates * 100.0 / partidas}%")
}

// Juego Sheldon: Pedra-Paper-Tisora-Llangardaix-Spock
fun juegoSheldon(sc: Scanner) {
    var partidas = 0
    var jugadorGana = 0
    var maquinaGana = 0
    var empates = 0
    var jugar = true

    while (jugar) {
        var jugadaUsuario = 0
        while (jugadaUsuario !in 1..5) {
            println("Elige tu jugada: 1=Pedra, 2=Paper, 3=Tisora, 4=Llangardaix, 5=Spock")
            jugadaUsuario = sc.nextInt()
            if (jugadaUsuario !in 1..5) println("Jugada inválida, intenta de nuevo.")
        }

        val jugadaMaquina = Random.nextInt(1, 6)
        val nombre = arrayOf("", "Pedra", "Paper", "Tisora", "Llangardaix", "Spock")
        println("Jugador: ${nombre[jugadaUsuario]} vs Máquina: ${nombre[jugadaMaquina]}")

        if (jugadaUsuario == jugadaMaquina) empates++
        else if ((jugadaUsuario == 1 && (jugadaMaquina == 3 || jugadaMaquina == 4)) ||
            (jugadaUsuario == 2 && (jugadaMaquina == 1 || jugadaMaquina == 5)) ||
            (jugadaUsuario == 3 && (jugadaMaquina == 2 || jugadaMaquina == 4)) ||
            (jugadaUsuario == 4 && (jugadaMaquina == 2 || jugadaMaquina == 5)) ||
            (jugadaUsuario == 5 && (jugadaMaquina == 1 || jugadaMaquina == 3))) jugadorGana++
        else maquinaGana++

        partidas++
        print("¿Quieres jugar otra vez? (s/n): ")
        val respuesta = sc.next()
        jugar = respuesta.lowercase() == "s"
    }

    println("\nEstadísticas finales:")
    println("Partidas jugadas: $partidas")
    println("Jugador ganó: ${jugadorGana * 100.0 / partidas}%")
    println("Máquina ganó: ${maquinaGana * 100.0 / partidas}%")
    println("Empates: ${empates * 100.0 / partidas}%")
}