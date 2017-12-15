<?php
/**
 * CakePHP(tm) : Rapid Development Framework (https://cakephp.org)
 * Copyright (c) Cake Software Foundation, Inc. (https://cakefoundation.org)
 *
 * Licensed under The MIT License
 * For full copyright and license information, please see the LICENSE.txt
 * Redistributions of files must retain the above copyright notice.
 *
 * @copyright Copyright (c) Cake Software Foundation, Inc. (https://cakefoundation.org)
 * @link      https://cakephp.org CakePHP(tm) Project
 * @since     0.2.9
 * @license   https://opensource.org/licenses/mit-license.php MIT License
 */
namespace App\Controller;

use Cake\Controller\Controller;
use Cake\Event\Event;
use Cake\Http\Client;

/**
 * Application Controller
 *
 * Add your application-wide methods in the class below, your controllers
 * will inherit them.
 *
 * @link https://book.cakephp.org/3.0/en/controllers.html#the-app-controller
 */
class AppController extends Controller
{
    public $http;

    /**
     * Initialization hook method.
     *
     * Use this method to add common initialization code like loading components.
     *
     * e.g. `$this->loadComponent('Security');`
     *
     * @return void
     */
    public function initialize()
    {
        parent::initialize();

        $this->http = new Client();

        $this->loadComponent('RequestHandler');
        $this->loadComponent('Flash');
        /*$this->loadComponent('Auth', [
            /*'authorize' => ['Controller'],
            'loginAction' => [
                'controller' => 'Login',
                'action' => 'index'
            ],
            'loginRedirect' => [
                'controller' => 'Home',
                'action' => 'index'
            ],
            'logoutRedirect' => [
                'controller' => 'Home',
                'action' => 'index'
            ],'authenticate' => [
                'Form' /*=> array (
                    /*'userModel' => 'User',
                    'fields' => array(
                        'User.Pseudo' => 'username',
                        'User.Password' => 'password'
                    )*/
                //)
            //]
        //]);
        /*
         * Enable the following components for recommended CakePHP security settings.
         * see https://book.cakephp.org/3.0/en/controllers/components/security.html
         */
        //$this->loadComponent('Security');
        //$this->loadComponent('Csrf');
    }

    public function isAuthorized($user)
    {
        // Admin peuvent accéder à chaque action
        /*if (isset($user)) {
            return true;
        }*/

        // Par défaut refuser
        return true;
    }

    /**
     * Before render callback.
     *
     * @param \Cake\Event\Event $event The beforeRender event.
     * @return \Cake\Http\Response|null|void
     */
    public function beforeRender(Event $event)
    {
        // Note: These defaults are just to get started quickly with development
        // and should not be used in production. You should instead set "_serialize"
        // in each action as required.
        if (!array_key_exists('_serialize', $this->viewVars) &&
            in_array($this->response->type(), ['application/json', 'application/xml'])
        ) {
            $this->set('_serialize', true);
        }
    }

    /**
     * @param $action The action of REST service (base url is http://127.0.0.1:8081/NataRest/api/)
     * @return The result of the request
     */
    public function callRest($action) {
        $response = $this->http->get("http://192.168.128.13:8081/NataRest/api/" . $action,  ['q' => 'widget'], [
            'headers' => [
                'api-key' => '24321d8c-b1b3-45bc-9d21-038dfc33b34c',
                'Content-Type' => 'application/json'
            ]
        ]);
        if($response->getStatusCode() >= 200 && $response->getStatusCode() <= 299)
            return json_decode($response->body());
    }

    public function write($key, $value) {
        if(isset($key) && !empty($key) && isset($value) && !empty($value)){
            $this->request->session()->write($key, $value);
        };
    }

    public function read($key) {
        $value = $this->request->session()->read($key);
        return (isset($value) && !empty($value)) ? $value : null;
    }
}
