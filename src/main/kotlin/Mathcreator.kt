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
        val simpleTaskRepetition = 4
        val complexTaskRepetition = 1
        val taskNumber: AtomicInt = atomic(1)

        newSimpleCalculationIteration(simpleTaskRepetition, taskNumber) { BasicCalculation.simpleAddition(20) }
        newSimpleCalculationIteration(simpleTaskRepetition, taskNumber) { BasicCalculation.complexAddition(20) }
        newSimpleCalculationIteration(simpleTaskRepetition, taskNumber) { BasicCalculation.simpleResting(20) }
        newSimpleCalculationIteration(1, taskNumber) { BasicCalculation.complexResting(20) }
        repeat(complexTaskRepetition) {
            child(CalculationComponent::class) {
                attrs.text = newRestMoneyTask(taskNumber.getAndIncrement())
            }
        }
        insertNewLinesAndControlText()
        repeat(complexTaskRepetition) {
            child(CalculationComponent::class) {
                attrs.text = newPaidMoneyTask(taskNumber.getAndIncrement())
            }
        }
        insertNewLinesAndControlText()
    }

    private fun RBuilder.newSimpleCalculationIteration(simpleTaskRepetition: Int, taskNumber: AtomicInt, basicCalculation: () -> BasicCalculation) {
        p {
            table {
                tbody {
                    repeat(simpleTaskRepetition) {
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

    private fun newRestMoneyTask(taskNumber: Number): String {
        val numbersForCalculation = BasicCalculation.complexResting(20)

        val secondCent = numbersForCalculation.secondCent.toString().padEnd(2, '0')
        return "$taskNumber: Wenn ich einkaufen gehe und ${numbersForCalculation.first}\$ mitnehme und dann mit ${numbersForCalculation.second},$secondCent\$ zurück komme. Wie viel Geld habe ich dann für meinen Einkauf bezahlt?"
    }

    private fun newPaidMoneyTask(taskNumber: Number): String {
        val numbersForCalculation = BasicCalculation.complexResting(20)

        val secondCent = numbersForCalculation.secondCent.toString().padEnd(2, '0')
        return "$taskNumber: Wenn ich einkaufen gehe und ${numbersForCalculation.first}\$ mitnehme und dann etwas für ${numbersForCalculation.second},$secondCent\$ kaufen möchte. Wie viel Geld bekomme ich dann zurück?"
    }
}
