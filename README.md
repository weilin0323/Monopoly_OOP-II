# Monopoly

簡易大富翁遊戲

程式執行之後，首先會跳出「開始遊戲介面」，介面示意圖 如下：
<img width="159" alt="截圖 2023-10-16 下午10 58 23" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/015cfc3f-fde3-43ec-851e-0dca64478682">

根據使用者不同的操作，會觸發以下不同事件：

i. 當使用者點擊"Start"之後，程式將跳轉至遊戲畫面， 此時遊戲畫面需生成4個玩家角色於起點，並且同時 生成 "Character.txt" 與 "Land.txt" 兩個檔案 作為遊戲數 據初始檔。遊戲開始畫面與初始數據如下所示：

<img width="494" alt="截圖 2023-10-16 下午10 29 53" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/70e8f6d5-a7ce-4e8d-97ce-23ee4de4249c">
Character.txt 初始生成數據
<img width="265" alt="截圖 2023-10-16 下午11 00 30" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/fb6a2c4d-0f03-43c6-8b7a-d01866581a77">
Land.txt 初始生成數據
<img width="172" alt="截圖 2023-10-16 下午11 00 49" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/06d2d31f-06b0-4037-976b-6ac011e8ec23">

ii.若使用者點擊"Load"按鈕，則讀取已存在的遊戲記錄 檔並跳轉至遊戲畫面，根據當前遊戲數據在畫面上顯 示玩家的金錢、角色位置以及其他需顯示的遊戲資料。 若在資料夾中沒有任何記錄檔，則需顯示「錯誤訊息 介面」。「錯誤訊息介面」視窗大小為150*100，且使 用者無法自行更改視窗大小，視窗中的文字內容同學 可自行發揮。「錯誤訊息介面」示意圖如下：
<img width="169" alt="截圖 2023-10-16 下午11 02 02" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/31dfbda0-89d0-42ce-b094-5de53a6dbeda">


iii.若使用者點擊"Exit"按鈕，則程式直接結束執行。

玩家擲完骰子並且角色移動到格子之後，將根據不同情況 行以下「土地」相關事件： 
a、 若玩家到達的土地為無人擁有狀態，則跳出「是否購買」 視窗，視窗中敘述需包含該土地的價格，以及「是」、「否」 按鈕。視窗示意圖如下：
<img width="283" alt="截圖 2023-10-16 下午10 56 10" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/07c592f8-b80e-4f9d-8da1-aef63cd34e6c">

若玩家選擇「是」，則玩家成為該土地的「地主」，同時 玩家金錢需扣除土地價格，並在當前土地上顯示玩家編 號，表示土地為當前玩家所有。執行後示意圖如下：
<img width="108" alt="截圖 2023-10-16 下午10 56 51" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/f9b30007-edde-484f-83ec-5c3a869469b7">


若玩家選擇「否」，則不觸發任何事件，並輪到下一位玩 家擲骰子。 b、 若玩家到達的土地為有主地，則跳出「繳納過路費」視 窗，並扣除玩家金錢。視窗中敘述需包含繳錢的玩家與 擁有該地的玩家，以及繳納的過路費金額。視窗示意圖 如下：
<img width="345" alt="截圖 2023-10-16 下午10 57 19" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/c0285eeb-5f9b-4576-8d2f-35067b04216b">

c、 若玩家到達的土地為自己擁有的土地，則不觸發任何事 件，直接輪到下一位玩家擲骰子。

d、 若玩家到達「機會」或「命運」，同樣不觸發任何事件， 直接輪到下一位玩家擲骰子。 e、 當玩家經過或踩到起點時，可以獲得2000元，不需有視

窗或文字顯示獲得，只需更動上方顯示金錢部分。

5. 每當前一位玩家移動完且執行完「土地」相關事件之後，下 一位玩家始能擲骰子，並且此時地圖上的「Turn Character 編 號」才能改變。

6. 本次作業中，「地主」不會改變，玩家也不需要蓋房子。

8. 本次作業中，玩家的金錢可以為負數。


a. Character.txt 
第一行：當前回合數, 當前輪到的角色編號 以下格式為 location, CHARACTER_NUMBER, money, status, IMAGE_FILENAME 分別對應的Character 的各個變數。

b. Land.txt 格式為 LOCATION_NUMBER , owner 對應到Land 的 LOCATION_NUMBER 與owner。
