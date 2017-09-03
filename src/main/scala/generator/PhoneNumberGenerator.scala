package generator

import java.util.Locale.getISOCountries

import com.google.i18n.phonenumbers.PhoneNumberUtil

import scala.util.Random

object PhoneNumberGenerator {

  private val invalidCountries = List("AN", "AQ", "BV", "GS", "HM", "PN", "TF", "UM")

  private val countryCodes = getISOCountries.filter(country => !invalidCountries.contains(country))

  def generate(): Map[String, String] = {
    val util = PhoneNumberUtil.getInstance()

    val countryCode = countryCodes(Random.nextInt(countryCodes.length))

    val examplePhoneNumber = util.getExampleNumber(countryCode)
    val phoneNumber = Random.shuffle(examplePhoneNumber.getNationalNumber.toString.split("").toList) mkString

    Map("countryCode" -> countryCode, "phoneNumber" -> phoneNumber)
  }

}