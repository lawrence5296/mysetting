    var particleSystem = null;
    var stage = null;
    //  ウィンドウのロードが終わり次第、初期化コードを呼び出す。
    window.addEventListener("load", function () {
      // Stageオブジェクトを作成します。表示リストのルートになります。
      stage = new createjs.Stage("myCanvas");
      // パーティクルシステム作成します。
      particleSystem = new particlejs.ParticleSystem();
      // パーティクルシステムの描画コンテナーを表示リストに登録します。
      stage.addChild(particleSystem.container);
      // Particle Develop( http://ics-web.jp/projects/particle-develop/ ) から書きだしたパーティクルの設定を読み込む
      particleSystem.importFromJson(
        // パラメーターJSONのコピー＆ペースト ここから--
        {
            "bgColor": "#00000",
            "width": 1400,
            "height": "543",
            "emitFrequency": "100",
            "startX": 691,
            "startXVariance": 1024,
            "startY": 310,
            "startYVariance": 217,
            "initialDirection": "0",
            "initialDirectionVariance": "360",
            "initialSpeed": "11.1",
            "initialSpeedVariance": 3.1,
            "friction": "0.038",
            "accelerationSpeed": "0.13",
            "accelerationDirection": "273.3",
            "startScale": 0.55,
            "startScaleVariance": "1",
            "finishScale": "0",
            "finishScaleVariance": "0",
            "lifeSpan": "50",
            "lifeSpanVariance": "196",
            "startAlpha": "1",
            "startAlphaVariance": "0",
            "finishAlpha": "0.35",
            "finishAlphaVariance": 0.5,
            "shapeIdList": [
                "blur_circle",
                "circle",
                "kirakira"
            ],
            "startColor": {
                "hue": 43,
                "hueVariance": "55",
                "saturation": "71",
                "saturationVariance": "78",
                "luminance": "83",
                "luminanceVariance": "16"
            },
            "blendMode": true,
            "alphaCurveType": "1"
        }
        // パラメーターJSONのコピー＆ペースト ここまで---
      );
      // フレームレートの設定
      createjs.Ticker.framerate = 60;
      // requestAnimationFrameに従った呼び出し
      createjs.Ticker.timingMode = createjs.Ticker.RAF;
      // 定期的に呼ばれる関数を登録
      createjs.Ticker.addEventListener("tick", handleTick);
    });
    function handleTick() {
      // パーティクルの発生・更新
      particleSystem.update();
      // 描画を更新する
      stage.update();
    }
