package com.sychev.mashaplus.provider

object ScrollToViewEventProvider {

    private var contactsScrollToEvent: (() -> Unit)? = null

    fun sendContactsScrollEvent() {
        contactsScrollToEvent?.invoke()
    }

    fun setContactsScrollEvent(action: () -> Unit) {
        contactsScrollToEvent = action
    }


}