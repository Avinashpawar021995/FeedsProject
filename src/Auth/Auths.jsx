
// isLoggedIn=>
    export const isLoggeIn=()=>{
        let data= localStorage.getItem("data")
         if(data!=null)
         {
          return true;
         }else{
          return false;
         }
      };
       
      //  doLogin => data=> set tp localstorage
       export const doLogin =(data,next)=>{
          localStorage.setItem("data",JSON.stringify(data))
           next()
      };
      
      
      //doLogout =>remove from local strorage
      
        export const doLogout =(next)=>{
          localStorage.removeItem("data");
       next()  
      }
      //get current user
      
      export const getCurrentUserDetails=()=>{
          if(isLoggeIn()){
                  console.log(JSON.parse(localStorage.getItem("data")).data);
            return JSON.parse(localStorage.getItem("data")).user;
          }else{
              return undefined;
          }
      }
      