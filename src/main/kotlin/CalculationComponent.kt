import kotlinx.html.P
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.RDOMBuilder
import react.dom.b
import react.dom.br
import react.dom.p

@ExperimentalJsExport
@JsExport
class CalculationComponentProps(var text: String) : RProps

@ExperimentalJsExport
@JsExport
class CalculationComponent(props: CalculationComponentProps) : RComponent<CalculationComponentProps, RState>(props) {
    override fun RBuilder.render() {
        p {
            b {
                +props.text
            }
            resultEntries()
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
}

