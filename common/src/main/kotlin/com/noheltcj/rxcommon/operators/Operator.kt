package com.noheltcj.rxcommon.operators

import com.noheltcj.rxcommon.Source
import com.noheltcj.rxcommon.emitters.Emitter
import com.noheltcj.rxcommon.observers.Observer

abstract class Operator<E> : Source<E>, Observer<E> {
  abstract val emitter: Emitter<E>

  override fun onNext(value: E) {
    emitter.next(value)
  }

  override fun onError(throwable: Throwable) {
    emitter.terminate(throwable)
  }

  override fun onComplete() {
    emitter.complete()
  }
}