
function deleteUser(userID){
    if(confirm("Are you sure you want to delete this user?")){
        url = `${document.location.origin}${document.location.pathname}?id=${userID}`
        console.log(url)
        fetch(url,{
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res =>{
            if(res.ok){
                location.reload();
            }else{
                alert("Failed to delete user")
            }
        }).catch(error=>{
            console.error('Error:', error);
            alert("We have a error")
        })
    }
}