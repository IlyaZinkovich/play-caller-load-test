package generator

import org.scalatest.FlatSpec

class PhoneNumberGeneratorSpec extends FlatSpec {

  "phone number generator" should "generate random phone nubmer" in {
    val generatedData: Map[String, String] = PhoneNumberGenerator.generate()

    val generatedCountryCode = generatedData("countryCode")
    assert(generatedCountryCode.length == 2)
    assert(generatedCountryCode == generatedCountryCode.toUpperCase)
    val generatedPhoneNumber = generatedData("phoneNumber")
    assert(!generatedPhoneNumber.isEmpty)
  }
}
