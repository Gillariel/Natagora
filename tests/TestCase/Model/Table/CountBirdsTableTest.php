<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountBirdsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountBirdsTable Test Case
 */
class CountBirdsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountBirdsTable
     */
    public $CountBirds;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_birds'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountBirds') ? [] : ['className' => CountBirdsTable::class];
        $this->CountBirds = TableRegistry::get('CountBirds', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountBirds);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
