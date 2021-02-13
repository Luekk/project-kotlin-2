fun main(args: Array<String>) {
    val input = readLine()
    val console = Console()
    val client = Client(Processor("Intel Core I7"), Graphics("RTX 3090"), RAM(16))
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))


//    input
//    if(input == "info"){
//        client.infoClient()
//    }else if(input == "info serv"){
//        println("wyswietlam info serwera")
//    }
//    server.infoServer()
//    fun req(){
//        client.serverSend()
//        server.req(10,20)
//    }
//    req()

    console.init()
}