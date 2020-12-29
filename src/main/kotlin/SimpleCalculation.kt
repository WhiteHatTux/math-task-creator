import kotlinx.css.TextAlign
import kotlinx.css.textAlign
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.p
import react.dom.td
import react.dom.tr
import styled.css
import styled.styledDiv

@ExperimentalJsExport
@JsExport
class SimpleCalculationProps(var taskNumber: Number, var basicCalculation: () -> BasicCalculation) : RProps

@ExperimentalJsExport
@JsExport
class SimpleCalculation(props: SimpleCalculationProps) : RComponent<SimpleCalculationProps, RState>(props) {
    override fun RBuilder.render() {
        var c = 'a'
        tr {
            td {
                +"${props.taskNumber}: "
            }
            while (c <= 'c') {
                val numbersForCalculation = props.basicCalculation()
                td {
                    +"$c)"
                }
                td {
                    styledDiv {
                        css {
                            textAlign = TextAlign.right
                        }
                        +"${numbersForCalculation.first}"
                    }

                }
                td {
                    +numbersForCalculation.operator
                }
                td {
                    styledDiv {
                        css {
                            textAlign = TextAlign.right
                        }
                        var text = "${numbersForCalculation.second}"
                        if (numbersForCalculation.secondCent > 0) {
                            val secondCent = numbersForCalculation.secondCent.toString().padEnd(2, '0')
                            text += ",$secondCent"
                        }
                        +text

                    }
                }
                td {
                    +"="
                }
                td {
                    if (numbersForCalculation.secondCent > 0) {
                        +"___________"
                    } else {
                        +"______"
                    }
                }
                td {
                    p {
                        +""
                    }
                }
                td {
                    p {
                        +""
                    }
                }
                ++c
            }

        }
    }
}
