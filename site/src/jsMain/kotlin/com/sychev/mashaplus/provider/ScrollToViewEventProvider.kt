package com.sychev.mashaplus.provider

object ScrollToViewEventProvider {

    private var contactsScrollToEvent: (() -> Unit)? = null
    private var vocalistScrollToEvent: (() -> Unit)? = null
    private var duetScrollToEvent: (() -> Unit)? = null
    private var vocalShowScrollToEvent: (() -> Unit)? = null
    private var ultimaBandScrollToEvent: (() -> Unit)? = null

    fun sendContactsScrollEvent() {
        contactsScrollToEvent?.invoke()
    }

    fun setContactsScrollEvent(action: () -> Unit) {
        contactsScrollToEvent = action
    }

    fun sendVocalistScrollEvent() {
        vocalistScrollToEvent?.invoke()
    }

    fun setVocalistScrollEvent(action: () -> Unit) {
        vocalistScrollToEvent = action
    }

    fun sendDuetScrollEvent() {
        duetScrollToEvent?.invoke()
    }

    fun setDuetSectionEvent(action: () -> Unit) {
        duetScrollToEvent = action
    }

    fun sendVocalShowScrollEvent() {
        vocalShowScrollToEvent?.invoke()
    }

    fun setVocalShowSectionEvent(action: () -> Unit) {
        vocalShowScrollToEvent = action
    }

    fun sendUltimaBandScrollEvent() {
        ultimaBandScrollToEvent?.invoke()
    }

    fun setUltimaBandSectionEvent(action: () -> Unit) {
        ultimaBandScrollToEvent = action
    }


}