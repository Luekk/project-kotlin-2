class Graphics (val graphics: String) {
    fun info():String{
        if(graphics == "none"){
            return "nie posiada karty graficznej"
        }else {
            return "$graphics"
        }
    }
}