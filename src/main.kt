fun main(args: Array<String>) {
    val console = Console()
    val client = Client(Processor("Intel Core I7"), Graphics("RTX 3090"), RAM(16))
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))
    //server.req(1,2)
    console.init()
}