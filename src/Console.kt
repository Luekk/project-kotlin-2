import java.util.Scanner

class Console {
    val client = Client(Processor("Intel Core I7"), Graphics("RTX 3090"), RAM(16))
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))

    fun init(){
        println("Emulacja server-client...")
        println("Wpisz -h lub -help aby zobaczyć pomoc")
        start()
    }
    private fun start():String{
        var type:String? = Scanner.(System.`in`)
        if(type == "-h" || type == "-help"){
            help()
        }
        if(type == "client -params") {
            parameters()
        }
        return type
    }
    private fun help(){
        println("pomoc")
        start()
    }
    private fun parameters(){
        if(start() == "client -params") {
            client.infoClient()
        } else if (start() == "server -params"){
            server.infoServer()
        }
    }
}