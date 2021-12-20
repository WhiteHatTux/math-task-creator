import kotlinx.atomicfu.AtomicInt
import kotlinx.atomicfu.atomic
import kotlinx.browser.document
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.br
import react.dom.p
import react.dom.table
import react.dom.tbody
import kotlin.js.Date
import kotlin.time.ExperimentalTime

@ExperimentalJsExport
@JsExport
class MathCreator(props: RProps) : RComponent<RProps, RState>(props) {

    @ExperimentalTime
    override fun RBuilder.render() {
        val month: Int = Date().getMonth() + 1
        val now = Date().getFullYear().toString() + "-" + month + "-" + Date().getDate()
        document.title = "Generator für Matheaufgaben vom $now"
        val textTaskRepetion = 1
        val taskNumber: AtomicInt = atomic(1)

        newSimpleCalculationIteration(3, taskNumber) { BasicCalculation.simpleResting(100) }
        newSimpleCalculationIteration(2, taskNumber) { BasicCalculation.simpleHighRangeAddition(500) }
        newSimpleCalculationIteration(3, taskNumber) { BasicCalculation.simpleMultiplication(100, 10) }
        newSimpleCalculationIteration(2, taskNumber) { BasicCalculation.simpleMultiplication(200, 5) }
        newSimpleCalculationIteration(2, taskNumber) { BasicCalculation.complexResting(20) }
        newSimpleCalculationIteration(2, taskNumber) { BasicCalculation.simpleDivision(10) }
        repeat(textTaskRepetion) {
            child(CalculationComponent::class) {
                attrs.text = newDivideBillBetweenFriendsTask(taskNumber.getAndIncrement())
            }
        }
        insertNewLinesAndControlText()
        repeat(textTaskRepetion) {
            child(CalculationComponent::class) {
                attrs.text = newPaidMoneyTask(taskNumber.getAndIncrement())
            }
        }
        insertNewLinesAndControlText()
    }

    private fun RBuilder.newSimpleCalculationIteration(taskRepetition: Int, taskNumber: AtomicInt, basicCalculation: () -> BasicCalculation) {
        p {
            table {
                tbody {
                    repeat(taskRepetition) {
                        child(SimpleCalculation::class) {
                            attrs.taskNumber = taskNumber.getAndIncrement()
                            attrs.basicCalculation = basicCalculation
                        }
                    }
                }
            }
        }
    }

    private fun RBuilder.insertNewLinesAndControlText() {
        p {
            repeat(5) {
                br { }
            }
            +"Kontrolliert von: ________________________________"
        }
    }

    private fun newDivideBillBetweenFriendsTask(taskNumber: Number): String {
        val numbersForCalculation = BasicCalculation.simpleDivision(10)
        return "$taskNumber: Wenn ich mit meinen ${numbersForCalculation.second} Freunden Eis essen gehe und wir am Ende ${numbersForCalculation.first}\$ bezahlen müssen. Wie viel muss dann jeder von uns bezahlen?"
    }

    private fun newPaidMoneyTask(taskNumber: Number): String {
        val numbersForCalculation = BasicCalculation.complexResting(20)

        val secondCent = numbersForCalculation.secondCent.toString().padEnd(2, '0')
        return "$taskNumber: Wenn ich einkaufen gehe und ${numbersForCalculation.first}\$ mitnehme und dann etwas für ${numbersForCalculation.second},$secondCent\$ kaufen möchte. Wie viel Geld bekomme ich dann zurück?"
    }
}
