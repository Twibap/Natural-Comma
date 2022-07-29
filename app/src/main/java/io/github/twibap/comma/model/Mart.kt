package io.github.twibap.comma.model

class Mart {

    var itemFlags: Int = 0x00

    enum class Flag(val bit: Int, val value: String) {
        APPLE(32, "사과"),
        BERRY(16, "딸기"),
        BANANA(8, "바나나"),
        PEACH(4, "복숭아"),
        PLUM(2, "자두"),
        IS_OPEN(1, "팝니다."),
    }

    fun toggleFlag(flag: Flag) {
        if (itemFlags.and(flag.bit) > 0) {
            itemFlags -= flag.bit
        } else {
            itemFlags += flag.bit
        }
    }

}