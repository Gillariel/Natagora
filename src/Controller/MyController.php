<?php
/**
 * Created by PhpStorm.
 * User: foers
 * Date: 13-12-17
 * Time: 19:27
 */

namespace App\Controller;

use App\Model\Entity\User;
use Cake\Event\Event;
use Cake\ORM\TableRegistry;
use Cake\Datasource\ConnectionManager;


class MyController extends AppController
{


    public function initilize() {
        parent::initialize();
    }

    public function index() {
        $username = parent::read('Username');
        if(is_null($username)){
            $this->redirect('/login');
        }else {
            $pendings = $this->getPendedSessions($username);
            $sessions = $this->getValidSessions($username);
            $user = $this->getUser($username);

            $this->set('sessions', $sessions);
            $this->set('pendings', $pendings);
            $this->set('user', $user);
            $this->viewBuilder()->setLayout('');
        }
    }

    private function getUser($username) {
        $res = parent::callRest('users/retrieve/'.$username);
        return $res;
    }

    private function getValidSessions($username) {
        $ress = parent::callRest('sessions/observationsMedia/validated/'.$username);

        $sessions = [];
        $sessionIdAlreadyPresent = [];

        foreach ($ress as $res){
            $url = $res[0]; $text = $res[1];$sessionID = $res[3]; $comment = $res[4]; $mediaName = $res[5];

            //Check if sessionsID of obs is already present in $sessions
            //Else create a new entry with 'id' = $i representing a new session
            if(array_key_exists($sessionID , $sessionIdAlreadyPresent)){
                //Then add in 'observations' of the sessions[$i]
                array_push($sessions[$sessionID]['observations'], [
                    'media' => [
                        'url' => $url,
                        'name' => (isset($mediaName)) ? $mediaName : 'No Description'
                    ]
                ]);
            }else{
                $sessionIdAlreadyPresent[$res[3]] = 0;
                $sessions[$res[3]] = [
                    'comment' => (isset($comment)) ? $comment : 'No Session\'s name yet' ,
                    'observations' => [
                        '1' => [
                            'media' => [
                                'url' => $url,
                                'name' => (isset($mediaName)) ? $mediaName : 'No Description'
                            ]
                        ]
                    ]
                ];
            }
        }
        ksort($sessions);
        return $sessions;
    }

    private function getPendedSessions($username) {
        $ress = parent::callRest('sessions/observationsMedia/pended/'.$username);
        $sessions = [];
        $sessionIdAlreadyPresent = [];

        foreach ($ress as $res){
            $url = $res[0]; $text = $res[1];$sessionID = $res[3]; $comment = $res[4]; $mediaName = $res[5];

            //Check if sessionsID of obs is already present in $sessions
            //Else create a new entry with 'id' = $i representing a new session
            if(array_key_exists($sessionID , $sessionIdAlreadyPresent)){
                //Then add in 'observations' of the sessions[$i]
                array_push($sessions[$sessionID]['observations'], [
                    'media' => [
                        'url' => $url,
                        'name' => (isset($mediaName)) ? $mediaName : 'No Description'
                    ]
                ]);
            }else{
                $sessionIdAlreadyPresent[$res[3]] = 0;
                $sessions[$res[3]] = [
                    'comment' => (isset($comment)) ? $comment : 'No Session\'s name yet' ,
                    'observations' => [
                        '1' => [
                            'media' => [
                                'url' => $url,
                                'name' => (isset($mediaName)) ? $mediaName : 'No Description'
                            ]
                        ]
                    ]
                ];
            }
        }
        ksort($sessions);
        return $sessions;
    }
}