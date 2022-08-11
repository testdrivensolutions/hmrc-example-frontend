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

package pages

import models.UserAnswers
import pages.behaviours.PageBehaviours

import java.time.LocalDate

class DateOfBirthYesNoPageSpec extends PageBehaviours {

  "DateOfBirthYesNoPage" - {

    beRetrievable[Boolean](DateOfBirthYesNoPage)

    beSettable[Boolean](DateOfBirthYesNoPage)

    beRemovable[Boolean](DateOfBirthYesNoPage)

    "cleanup" - {
      "when NO selected" - {
        "must clean up DateOfBirthPage" in {
          val preChange  = UserAnswers("id").set(DateOfBirthPage, LocalDate.now()).get
          val postChange = preChange.set(DateOfBirthYesNoPage, false).get

          postChange.get(DateOfBirthPage) mustNot be(defined)
        }
      }
    }

    "when YES selected" - {
      "must do nothing" in {
        val preChange  = UserAnswers("id").set(DateOfBirthPage, LocalDate.now()).get
        val postChange = preChange.set(DateOfBirthYesNoPage, true).get

        postChange.get(DateOfBirthPage) must be(defined)
      }
    }
  }
}
