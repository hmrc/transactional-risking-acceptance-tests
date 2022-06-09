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

import uk.gov.hmrc.test.api.models.User
import uk.gov.hmrc.test.api.models.User._

class ExampleSpec extends BaseSpec {

  Feature("Example of using the Individuals Matching API") {

    Scenario("Get transactional risking hello worl response") {

      Given("There is an existing transactional risking api")
      //val authBearerToken: String    = authHelper.getAuthBearerToken
      val individualsMatchId: Unit = testDataHelper.createAnIndividual(ninoUser)
      //val authBearerToken: String    = authHelper.getAuthBearerToken
    // val individualsMatchId: String = testDataHelper.createAnIndividual( ninoUser)
      def  transactionalrisking :String = testDataHelper.obtainMatchIdFromHref()

      When("I invoke the transactional risking local endpoint")
      def createdUser : User = testDataHelper.createAnIndividual( ninoUser)
     //val actualUser: User =
        //individualsMatchingHelper.getIndividualByMatchId(authBearerToken, individualsMatchId)

      Then("api call returned with the details of expected response body")
      createdUser shouldBe ninoUser
      //actualUser shouldBe ninoUser
    }

  }
}
