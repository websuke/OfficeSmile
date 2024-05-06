'use strict'

const delay = 40 // fps=25

const fadeOut = async function(elem, duration = 500) {
    if (!elem) {
        throw new Error('elem is null')
    }

    if (elem.style.display === 'none') {
        return true // すでに非表示の場合は処理を終了
    }

    // delayの定義が必要
    const delay = 10

    // opacityを減少させてフェードアウトさせるアニメーション
    const coef = 1 / (duration / delay)
    elem.style.opacity = 1.0
    let opacity = Number(elem.style.opacity)

    // アニメーションを待機する関数を定義
    function wait(delay) {
        return new Promise(resolve => setTimeout(resolve, delay))
    }

    while (opacity > 0) {
        await wait(delay)
        opacity -= coef
        elem.style.opacity = opacity
    }

    elem.style.display = 'none'
    return true
}

const flashMessage = document.querySelector("#flashMessage")
if (flashMessage !== null) {
    setTimeout(() => {
        fadeOut(flashMessage, 2000)
    }, 2000)
}