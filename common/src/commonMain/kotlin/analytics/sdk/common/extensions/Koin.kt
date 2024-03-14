package analytics.sdk.common.extensions

import org.koin.core.parameter.parametersOf

@Suppress("UNCHECKED_CAST")
class MultiParameter(vararg val parameters: Any?) {
    operator fun <T> component1(): T = get(0)
    operator fun <T> component2(): T = get(1)
    operator fun <T> component3(): T = get(2)
    operator fun <T> component4(): T = get(3)
    operator fun <T> component5(): T = get(4)
    operator fun <T> component6(): T = get(5)
    operator fun <T> component7(): T = get(6)
    // Add more component functions as needed here

    operator fun <T> get(i: Int) = parameters[i] as T

    inline fun <reified T> get() = parameters.first { it is T }
}

fun multiParametersOf(vararg parameters: Any?) = parametersOf(MultiParameter(*parameters))