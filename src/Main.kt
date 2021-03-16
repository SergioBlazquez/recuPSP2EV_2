import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun main(){

    println("Introduzca texto para cifrar: ")
    val cifrar= readLine()
    val key="123"

    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE,key(key))
    val cifrado = Base64.getEncoder().encodeToString(cipher.doFinal(cifrar?.toByteArray(Charsets.UTF_8)))

    println("Texto cifrado: "+cifrado)

    println("Descifrar: "+cifrado)

    val cipher2 = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher2.init(Cipher.DECRYPT_MODE, key(key));


    println("Texto descifrado: "+String(cipher2.doFinal(Base64.getDecoder().decode(cifrado))))
}


fun key(key:String): SecretKeySpec{
    var aux1 = key.toByteArray(Charsets.UTF_8)
    val aux2 = MessageDigest.getInstance("SHA-1")
    aux1 = aux2.digest(aux1)
    aux1 = aux1.copyOf(16)
    return SecretKeySpec(aux1, "AES")


}