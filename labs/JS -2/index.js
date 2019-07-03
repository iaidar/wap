const button = document.querySelector('button')
const list = document.querySelector('.list-group')
var accountListInfo = []

const account = (function() {
    function create(name, deposit) {
        const acc = {accountName: name,deposit: deposit}
        accountListInfo.push(acc);
        return acc;
    }
    return {
        createAccount: (name, deposit) => create(name, deposit)
    }
})();

button.onclick = () => {
    const name = document.querySelector('input#account_name')
    const deposit = document.querySelector('input#deposit')
    if(name.value == '' || deposit.value == '')
    {
        alert('please fill out all the fields!')
    } else {
        account.createAccount(name.value, deposit.value)
        list.innerHTML += `<li class="list-group-item">
                                Account name: <b>${name.value}</b> 
                                Saving balance: <b>${deposit.value}</b>
                            </li>`
        clearInputs()
    }

    function clearInputs() {
        name.value = ''
        deposit.value = ''
    }
}
