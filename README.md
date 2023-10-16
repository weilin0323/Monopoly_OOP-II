# Monopoly


### 初始畫面說明
首先會跳出「開始遊戲介面」，示意圖如下：<br/>

<img width="159" alt="截圖 2023-10-16 下午10 58 23" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/015cfc3f-fde3-43ec-851e-0dca64478682">

根據使用者不同的操作，會觸發以下不同事件：

i. 當使用者點擊"Start"之後，程式將跳轉至遊戲畫面， 此時遊戲畫面會有4個玩家角色於起點，並且同時生成 "Character.txt" 與 "Land.txt" 兩個檔案作為遊戲數據初始檔。遊戲開始畫面與初始數據如下所示：
<center>
<img width="494" alt="截圖 2023-10-16 下午10 29 53" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/70e8f6d5-a7ce-4e8d-97ce-23ee4de4249c">
<center/>

Character.txt 初始生成數據及變數意義：<br/>
 第一行：當前回合數, 當前輪到的角色編號。
 1. location: 角色所處的地圖位置
 2. CHARACTER_NUMBER: 玩家編號
 3. money: 角色目前持有的金錢
 4. status: 角色目前的行動狀態
 5. IMAGE_FILENAME: 代表角色用的圖片名稱

<img width="265" alt="截圖 2023-10-16 下午11 00 30" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/fb6a2c4d-0f03-43c6-8b7a-d01866581a77"><br/>


Land.txt 初始生成數據及變數意義：<br/>
對應到Land 的 LOCATION_NUMBER 與當前所有地的地主、無主情況。

<img width="172" alt="截圖 2023-10-16 下午11 00 49" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/06d2d31f-06b0-4037-976b-6ac011e8ec23"><br/>

ii. 若使用者點擊"Load"按鈕，則會根據當前遊戲數據在畫面上顯示玩家的金錢、角色位置以及其他需顯示的遊戲資料。若在資料夾中沒有任何記錄檔，則會顯示「錯誤訊息介面」，示意圖如下：<br/>

<img width="169" alt="截圖 2023-10-16 下午11 02 02" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/31dfbda0-89d0-42ce-b094-5de53a6dbeda">

iii. 若使用者點擊"Exit"按鈕，則程式直接結束執行。

### 遊戲過程：
玩家擲完骰子並且角色移動到格子之後，將根據不同情況進行： <br/>
i. 若玩家到達的土地為無人擁有狀態，則跳出「是否購買」視窗，示意圖如下：<br/>

<img width="283" alt="截圖 2023-10-16 下午10 56 10" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/07c592f8-b80e-4f9d-8da1-aef63cd34e6c">

若玩家選擇「是」，則玩家成為該土地的「地主」，同時玩家金錢會扣除土地價格，並在當前土地上顯示玩家編號，表示土地為當前玩家所有，示意圖如下：<br/>

<img width="108" alt="截圖 2023-10-16 下午10 56 51" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/f9b30007-edde-484f-83ec-5c3a869469b7"><br/>

若玩家選擇「否」，則輪到下一位玩家擲骰子。 

ii. 若玩家到達的土地為有主地，則跳出「繳納過路費」視窗，並扣除玩家金錢。視窗示意圖如下：<br/>

<img width="345" alt="截圖 2023-10-16 下午10 57 19" src="https://github.com/weilin0323/Monopoly_OOP-II/assets/51693471/c0285eeb-5f9b-4576-8d2f-35067b04216b">

iii. 若玩家到達的土地為自己擁有的土地，則輪到下一位玩家擲骰子。
iv. 若玩家到達「機會」或「命運」，直接輪到下一位玩家擲骰子。 
v. 當玩家經過或踩到起點時，可以獲得2000元。


### 遊戲規則：
1. 地主不會改變，玩家也不需要蓋房子。
2. 玩家的金錢可以為負數。

### 檔案描述：
Character.java : 描述遊戲角色的基本架構，內含以下幾種變數

 1. location : 角色所處的地圖位置
 2. CHARACTER_NUMBER : 玩家編號
 3. money : 角色目前持有的金錢
 4. status : 角色目前的行動狀態
 5. IMAGE_FILENAME : 代表角色用的圖片名稱

Land.java：描述遊戲土地的基本架構，內含以下幾種變數

 1. PLACE_NUMBER：地圖編號，與 Character.location 互相對應
 2. owner：擁有地的地主的編號，若無地主則為 0，若有則與地主之 CHARACTER_NUMBER 互相對應。
 3. LAND_PRICE：購買地的價錢。
 4. TOLLS：過路費。

Checkpoint6.java :主程式檔。

GUI.java :圖形介面程式檔， GUI 介面與角色位置設置，並於 Checkpoint6.java 使用。

Character.txt :遊戲數據，其中包含回合數、當前輪到的玩家以及 Character的每項數值。

Land.txt ：遊戲數據，其中包含當前所有地的地主、無主情況。
