fun main(args: Array<String>) {

    val age = 19

	
    val msg = when{
        age < 18 -> "young"
        age > 18 -> "adult"
        else -> "border"
		// else is mandratory for 'when'
    }
    
    println(msg)


}