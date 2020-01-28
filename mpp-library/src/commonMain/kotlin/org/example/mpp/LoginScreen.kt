package org.example.mpp

import dev.icerock.moko.fields.FormField
import dev.icerock.moko.fields.liveBlock
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.widgets.*
import dev.icerock.moko.widgets.core.Theme
import dev.icerock.moko.widgets.core.Value
import dev.icerock.moko.widgets.screen.Args
import dev.icerock.moko.widgets.screen.WidgetScreen
import dev.icerock.moko.widgets.style.view.WidgetSize

class LoginScreen(
    private val theme: Theme
) : WidgetScreen<Args.Empty>() {

    override fun createContentWidget() = with(theme) {
        constraint(size = WidgetSize.AsParent) {
            val nameInput = +input(
                size = WidgetSize.WidthAsParentHeightWrapContent,
                id = Ids.Name,
                label = const("Name"),
                field = FormField(initialValue = "", validation = liveBlock { null })
            )

            val submitButton = +button(
                size = WidgetSize.WidthAsParentHeightWrapContent,
                content = ButtonWidget.Content.Text(Value.data("Submit".desc()))
            ) {
                println("submit pressed")
            }

            val textWidget = +text(
                TextWidget.DefaultCategory,
                WidgetSize.WrapContent,
                Ids.Text,
                const("Test text")
            )

            constraints {
                nameInput centerYToCenterY root
                nameInput leftRightToLeftRight root offset 16

                submitButton bottomToBottom root.safeArea offset 16
                submitButton leftRightToLeftRight root offset 16

                textWidget topToTop root
                textWidget bottomToBottom nameInput
                textWidget leftToLeft root
                textWidget rightToRight root
            }
        }
    }

    object Ids {
        object Name : InputWidget.Id
        object Text : TextWidget.Id
    }
}