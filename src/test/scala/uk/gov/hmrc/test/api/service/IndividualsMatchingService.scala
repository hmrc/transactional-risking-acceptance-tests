/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.api.service

import play.api.libs.json.Json
import play.api.libs.ws.StandaloneWSRequest
import uk.gov.hmrc.test.api.client.HttpClient
import uk.gov.hmrc.test.api.conf.TestConfiguration
import uk.gov.hmrc.test.api.models.User

import scala.concurrent.Await
import scala.concurrent.duration._

class IndividualsMatchingService extends HttpClient {
  val host: String = TestConfiguration.url("ims")
  val individualsMatchingURL: String = s"$host/transactional-risking/hello-world"

  def getIndividualByMatchId(): StandaloneWSRequest#Self#Response =
    Await.result(
      get(
        individualsMatchingURL,
      ),
      10.seconds
    )

  def getIndividualUserService(individual: User): StandaloneWSRequest#Self#Response = {
    val individualPayload = Json.toJsObject(individual)
    println(s"The individualPayload = ${individualPayload} and the value for individualsMatchingURL = ${individualsMatchingURL}")
    Await.result(
      get(
        individualsMatchingURL,
      ),
      10.seconds
    )
  }
}
