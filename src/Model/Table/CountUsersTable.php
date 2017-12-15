<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * CountUsers Model
 *
 * @method \App\Model\Entity\CountUser get($primaryKey, $options = [])
 * @method \App\Model\Entity\CountUser newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\CountUser[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\CountUser|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\CountUser patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\CountUser[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\CountUser findOrCreate($search, callable $callback = null, $options = [])
 */
class CountUsersTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('count_users');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        return $validator;
    }
}
