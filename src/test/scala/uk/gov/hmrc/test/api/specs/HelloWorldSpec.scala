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

package uk.gov.hmrc.test.api.specs

import play.api.libs.ws.StandaloneWSRequest
import uk.gov.hmrc.test.api.models.User
import uk.gov.hmrc.test.api.models.User._

import scala.::

class HelloWorldSpec extends BaseSpec {

  Feature("Example of using the Individuals Matching API") {

    Scenario("Get transactional risking hello world response") {

      When("I invoke the transactional risking local endpoint")
      val userResponse: StandaloneWSRequest#Self#Response = testDataHelper.getHelloWorldUser(ninoUser)

      Then("api call returned with the details of expected response body")
      userResponse.status shouldBe 200
      val returnedUser: String = userResponse.body
      User(returnedUser) shouldBe ninoUser

    }

  }
}
