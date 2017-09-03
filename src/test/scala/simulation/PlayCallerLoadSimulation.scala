package simulation

import generator.PhoneNumberGenerator
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class PlayCallerLoadSimulation extends Simulation {

  private val feeder = Iterator.continually(PhoneNumberGenerator.generate())

  private val httpConf = http
    .baseURL("http://localhost:9000")
    .acceptHeader("application/json")

  private val scn = scenario("ProfilesFetching")
    .feed(feeder)
    .exec(http("get profile by phone number")
      .get("/search?countryCode=${countryCode}&phoneNumber=${phoneNumber}"))

  setUp(
    scn.inject(heavisideUsers(3000) over (20 seconds))
  ).protocols(httpConf)
}