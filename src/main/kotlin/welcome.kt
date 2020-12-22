import kotlinx.browser.document
import kotlinx.html.P
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import kotlin.js.Date
import kotlin.random.Random
import kotlin.time.ExperimentalTime

@JsExport
class Welcome(props: RProps) : RComponent<RProps, RState>(props) {

    @ExperimentalTime
    override fun RBuilder.render() {
        val month: Int = Date().getMonth() + 1
        val now = Date().getFullYear().toString() + "-" + month + "-" + Date().getDate()
        document.title = "Generator für Matheaufgaben vom $now"
        val taskRepetition = 4
        repeat(taskRepetition) { index ->
            p {
                b { +newRestMoneyTask(index + 1) }
                resultEntries()
            }
        }
        insertNewLinesAndControlText()
        div("pagebreak") {
        }
        repeat(taskRepetition) { index ->
            p {
                b { +newPaidMoneyTask(taskRepetition + index + 1) }
                resultEntries()
            }
        }
        insertNewLinesAndControlText()
    }

    private fun RBuilder.insertNewLinesAndControlText() {
        p {
            repeat(5) {
                br { }
            }
            +"Kontrolliert von: ________________________________"
        }
    }


    private fun RDOMBuilder<P>.resultEntries() {
        repeat(3) {
            br {}
        }
        +"Berechnung: ___________________________________________"
        repeat(3) {
            br {}
        }
        +"Kontrollaufgabe: ___________________________________________"
        repeat(3) {
            br {}
        }
        +"Ergebnis als ganzer Satz: __________________________________________________________________________________________________________"
    }

    private fun newRestMoneyTask(taskNumber: Number): String {
        val first = Random.nextInt(1, 20)
        val second = Random.nextInt(1, 20)
        val returnedCent = Random.nextInt(0, 99).toString().padEnd(2, '0')
        val total: Int
        val returned: Int
        if (first > second) {
            total = first
            returned = second
        } else {
            total = second
            returned = first
        }

        return "$taskNumber: Wenn ich einkaufen gehe und $total\$ mitnehme und dann mit $returned,$returnedCent\$ zurück komme. Wie viel Geld habe ich dann für meinen Einkauf bezahlt?"
    }

    private fun newPaidMoneyTask(taskNumber: Number): String {
        val first = Random.nextInt(1, 20)
        val second = Random.nextInt(1, 19)
        val paidCent = Random.nextInt(0, 99).toString().padEnd(2, '0')
        val total: Int
        val paidMoney: Int
        if (first > second) {
            total = first
            paidMoney = second
        } else {
            total = second
            paidMoney = first
        }

        return "$taskNumber: Wenn ich einkaufen gehe und $total\$ mitnehme und dann etwas für $paidMoney,$paidCent\$ kaufen möchte. Wie viel Geld bekomme ich dann zurück?"
    }
}
