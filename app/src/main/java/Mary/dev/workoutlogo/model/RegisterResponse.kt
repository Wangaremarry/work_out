package Mary.dev.workoutlogo.model

data class RegisterResponse(
    var message: String,
    var user: User,
    val firstName: String,
    val lastName: String,
    val phone_number: String,

    )

